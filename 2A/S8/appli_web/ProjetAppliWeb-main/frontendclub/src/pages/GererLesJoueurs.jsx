import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './GererLesJoueurs.css';

axios.interceptors.request.use(request => {
  if (request.method === 'post' || request.method === 'put') {
    if (request.data && typeof request.data !== 'string') {
      request.data = JSON.stringify(request.data);
      // S'assurer que l'en-tête Content-Type est correctement défini
      request.headers['Content-Type'] = 'application/json';
    }
  }
  return request;
});


const GererLesJoueurs = () => {
  const [joueurs, setJoueurs] = useState([]);
  const [selectedJoueur, setSelectedJoueur] = useState(null);
  const [statistiques, setStatistiques] = useState([]);
  const [showStats, setShowStats] = useState(false);
  const [showStatForm, setShowStatForm] = useState(false);
  const [editMode, setEditMode] = useState(false);

  // État du formulaire pour un nouveau joueur
  const [nouveauJoueur, setNouveauJoueur] = useState({
    nom: '',
    prenom: '',
    maillot: '',
    equipe: '',
    datenaissance: ''
  });

  // État du formulaire pour une nouvelle statistique
  const [nouvelleStat, setNouvelleStat] = useState({
    type: 'buts',
    valeur: 0
  });

  // Configuration d'Axios
  axios.defaults.headers.post['Content-Type'] = 'application/json';
  axios.defaults.headers.put['Content-Type'] = 'application/json';

  // Charger tous les joueurs non archivés au chargement de la page
  useEffect(() => {
    fetchJoueurs();
  }, []);

  // Récupérer la liste des joueurs
  const fetchJoueurs = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/joueurs');
      // Filtrer pour ne garder que les joueurs non archivés
      const joueursActifs = response.data.filter(joueur => !joueur.archived);
      setJoueurs(joueursActifs);
    } catch (error) {
      console.error('Erreur lors de la récupération des joueurs:', error);
    }
  };

  // Récupérer les statistiques d'un joueur
  const fetchStatistiques = async (joueurId) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/joueurs/${joueurId}/statistiques`);
      setStatistiques(response.data);
    } catch (error) {
      console.error('Erreur lors de la récupération des statistiques:', error);
    }
  };

  // Gérer la sélection d'un joueur
  const handleJoueurSelect = (joueur) => {
    setSelectedJoueur(joueur);
    fetchStatistiques(joueur.id);
    setShowStats(true);
    setShowStatForm(false);
    setEditMode(false);
  };

  // Gérer les changements dans le formulaire d'ajout de joueur
  const handleNouveauJoueurChange = (e) => {
    const { name, value } = e.target;
    setNouveauJoueur({
      ...nouveauJoueur,
      [name]: name === 'maillot' ? parseInt(value || 0) : value
    });
  };

  // Gérer les changements dans le formulaire d'ajout de statistique
  const handleNouvelleStatChange = (e) => {
    const { name, value } = e.target;
    setNouvelleStat({
      ...nouvelleStat,
      [name]: name === 'valeur' ? parseInt(value || 0) : value
    });
  };

  // Soumettre le formulaire d'ajout de joueur
  const handleSubmitJoueur = async (e) => {
    e.preventDefault();
    
    try {
      // Formatage des données avant envoi
      const joueurData = {
        nom: nouveauJoueur.nom,
        prenom: nouveauJoueur.prenom,
        maillot: parseInt(nouveauJoueur.maillot),
        equipe: nouveauJoueur.equipe,
        // Formater la date au format ISO sans heure
        datenaissance: nouveauJoueur.datenaissance // Déjà au format YYYY-MM-DD grâce à l'input type="date"
      };
      
      console.log("Données à envoyer:", joueurData);
      
      const response = await axios.post('http://localhost:8080/api/joueurs', joueurData, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      console.log("Réponse:", response.data);
      
      // Rafraîchir la liste après ajout
      fetchJoueurs();
      
      // Réinitialiser le formulaire
      setNouveauJoueur({
        nom: '',
        prenom: '',
        maillot: '',
        equipe: '',
        datenaissance: ''
      });
    } catch (error) {
      console.error('Erreur lors de l\'ajout du joueur:', error);
      alert('Une erreur s\'est produite lors de l\'ajout du joueur.');
    }
  };

  // Soumettre le formulaire de modification de joueur
  const handleUpdateJoueur = async (e) => {
    e.preventDefault();
    try {
      const joueurData = {
        ...selectedJoueur,
        maillot: parseInt(selectedJoueur.maillot)
      };
      
      await axios.put(`http://localhost:8080/api/joueurs/${selectedJoueur.id}`, joueurData, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      fetchJoueurs();
      setEditMode(false);
    } catch (error) {
      console.error('Erreur lors de la modification du joueur:', error);
      alert('Une erreur s\'est produite lors de la modification du joueur.');
    }
  };

  // Gérer les changements dans le formulaire de modification
  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setSelectedJoueur({
      ...selectedJoueur,
      [name]: name === 'maillot' ? parseInt(value || 0) : value
    });
  };

  // Soumettre le formulaire d'ajout de statistique
  const handleSubmitStat = async (e) => {
    e.preventDefault();
    try {
      const statToSubmit = {
        ...nouvelleStat,
        valeur: parseInt(nouvelleStat.valeur),
        joueur: { id: selectedJoueur.id }
      };
      
      await axios.post(`http://localhost:8080/api/joueurs/${selectedJoueur.id}/statistiques`, statToSubmit, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      
      // Rafraîchir les statistiques après ajout
      fetchStatistiques(selectedJoueur.id);
      
      // Réinitialiser le formulaire
      setNouvelleStat({
        type: 'buts',
        valeur: 0
      });
      
      setShowStatForm(false);
      setShowStats(true);
    } catch (error) {
      console.error('Erreur lors de l\'ajout de la statistique:', error);
      alert('Une erreur s\'est produite lors de l\'ajout de la statistique.');
    }
  };

  return (
    <div className="gerer-joueurs-container">
      <h1>Gestion des Joueurs</h1>
      
      <div className="content-container">
        {/* Partie gauche - Formulaire d'ajout de joueur */}
        <div className="left-panel">
          <h2>Ajouter un nouveau joueur</h2>
          <form onSubmit={handleSubmitJoueur} className="form-container">
            <div className="form-group">
              <label>Nom:</label>
              <input 
                type="text" 
                name="nom" 
                value={nouveauJoueur.nom} 
                onChange={handleNouveauJoueurChange} 
                required 
              />
            </div>
            
            <div className="form-group">
              <label>Prénom:</label>
              <input 
                type="text" 
                name="prenom" 
                value={nouveauJoueur.prenom} 
                onChange={handleNouveauJoueurChange} 
                required 
              />
            </div>
            
            <div className="form-group">
              <label>Numéro de maillot:</label>
              <input 
                type="number" 
                name="maillot" 
                value={nouveauJoueur.maillot} 
                onChange={handleNouveauJoueurChange} 
                required 
              />
            </div>
            
            <div className="form-group">
              <label>Équipe:</label>
              <input 
                type="text" 
                name="equipe" 
                value={nouveauJoueur.equipe} 
                onChange={handleNouveauJoueurChange} 
                required 
              />
            </div>
            
            <div className="form-group">
              <label>Date de naissance:</label>
              <input 
                type="date" 
                name="datenaissance" 
                value={nouveauJoueur.datenaissance} 
                onChange={handleNouveauJoueurChange} 
                required 
              />
            </div>
            
            <button type="submit" className="btn-submit">Ajouter</button>
          </form>
        </div>
        
        {/* Partie droite - Liste des joueurs et détails */}
        <div className="right-panel">
          <h2>Liste des joueurs</h2>
          <div className="joueurs-list">
            {joueurs.length > 0 ? (
              joueurs.map(joueur => (
                <div 
                  key={joueur.id} 
                  className={`joueur-item ${selectedJoueur && selectedJoueur.id === joueur.id ? 'selected' : ''}`}
                  onClick={() => handleJoueurSelect(joueur)}
                >
                  <span className="joueur-name">{joueur.nom} {joueur.prenom}</span>
                  <span className="joueur-number">#{joueur.maillot}</span>
                </div>
              ))
            ) : (
              <p>Aucun joueur disponible</p>
            )}
          </div>
          
          {/* Détails du joueur sélectionné */}
          {selectedJoueur && (
            <div className="joueur-details">
              {editMode ? (
                // Formulaire de modification
                <div className="edit-form">
                  <h3>Modifier les informations</h3>
                  <form onSubmit={handleUpdateJoueur}>
                    <div className="form-group">
                      <label>Nom:</label>
                      <input 
                        type="text" 
                        name="nom" 
                        value={selectedJoueur.nom} 
                        onChange={handleEditChange} 
                        required 
                      />
                    </div>
                    
                    <div className="form-group">
                      <label>Prénom:</label>
                      <input 
                        type="text" 
                        name="prenom" 
                        value={selectedJoueur.prenom} 
                        onChange={handleEditChange} 
                        required 
                      />
                    </div>
                    
                    <div className="form-group">
                      <label>Numéro de maillot:</label>
                      <input 
                        type="number" 
                        name="maillot" 
                        value={selectedJoueur.maillot} 
                        onChange={handleEditChange} 
                        required 
                      />
                    </div>
                    
                    <div className="form-group">
                      <label>Équipe:</label>
                      <input 
                        type="text" 
                        name="equipe" 
                        value={selectedJoueur.equipe} 
                        onChange={handleEditChange} 
                        required 
                      />
                    </div>
                    
                    <div className="form-group">
                      <label>Date de naissance:</label>
                      <input 
                        type="date" 
                        name="datenaissance" 
                        value={selectedJoueur.datenaissance} 
                        onChange={handleEditChange} 
                        required 
                      />
                    </div>
                    
                    <div className="button-group">
                      <button type="submit" className="btn-submit">Enregistrer</button>
                      <button 
                        type="button" 
                        className="btn-cancel"
                        onClick={() => setEditMode(false)}
                      >
                        Annuler
                      </button>
                    </div>
                  </form>
                </div>
              ) : showStats ? (
                // Affichage des statistiques
                <div className="stats-container">
                  <h3>Statistiques de {selectedJoueur.prenom} {selectedJoueur.nom}</h3>
                  
                  {statistiques.length > 0 ? (
                    <div className="stats-list">
                      {statistiques.map(stat => (
                        <div key={stat.id} className="stat-item">
                          <span className="stat-type">{stat.type}:</span>
                          <span className="stat-value">{stat.valeur}</span>
                        </div>
                      ))}
                    </div>
                  ) : (
                    <p>Aucune statistique disponible</p>
                  )}
                  
                  <div className="actions-container">
                    <button 
                      className="btn-action"
                      onClick={() => {
                        setShowStats(false);
                        setShowStatForm(true);
                      }}
                    >
                      Ajouter une statistique
                    </button>
                    <button 
                      className="btn-action"
                      onClick={() => setEditMode(true)}
                    >
                      Modifier les informations
                    </button>
                  </div>
                </div>
              ) : showStatForm ? (
                // Formulaire d'ajout de statistique
                <div className="stat-form-container">
                  <h3>Ajouter une statistique pour {selectedJoueur.prenom} {selectedJoueur.nom}</h3>
                  <form onSubmit={handleSubmitStat}>
                    <div className="form-group">
                      <label>Type:</label>
                      <select 
                        name="type" 
                        value={nouvelleStat.type} 
                        onChange={handleNouvelleStatChange}
                      >
                        <option value="buts">Buts</option>
                        <option value="passes">Passes</option>
                        <option value="fautes">Fautes</option>
                      </select>
                    </div>
                    
                    <div className="form-group">
                      <label>Valeur:</label>
                      <input 
                        type="number" 
                        name="valeur" 
                        value={nouvelleStat.valeur} 
                        onChange={handleNouvelleStatChange}
                        min="0"
                      />
                    </div>
                    
                    <div className="button-group">
                      <button type="submit" className="btn-submit">Enregistrer</button>
                      <button 
                        type="button" 
                        className="btn-cancel"
                        onClick={() => {
                          setShowStatForm(false);
                          setShowStats(true);
                        }}
                      >
                        Annuler
                      </button>
                    </div>
                  </form>
                </div>
              ) : null}
            </div>
          )}
          {!selectedJoueur && (
            <div className="joueur-details">
              <p>Sélectionnez un joueur pour voir ou modifier ses informations</p>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default GererLesJoueurs;