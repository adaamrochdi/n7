// src/pages/GererLesMatchs.jsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './GererLesMatchs.css';

export default function GererLesMatchs() {
  /* ---------- états ---------- */
  const [matchs, setMatchs] = useState([]);
  const [nouveauMatch, setNouveauMatch] = useState({
    id: null,
    date: '',
    heureDebut: '',
    heureFin: '',
    equipe: '',
    adversaire: '',
    terrain: ''
  });
  const navigate = useNavigate();

  /* ---------- chargement initial ---------- */
  useEffect(() => {
    chargerMatchs();
  }, []);

  /* ---------- appels API ---------- */
  const chargerMatchs = () => {
    axios.get('/api/matchs', { timeout: 5000 })
      .then(res => {
        let matchsArray;
        if (Array.isArray(res.data)) {
          matchsArray = res.data;
        } else if (res.data && Array.isArray(res.data.matchs)) {
          matchsArray = res.data.matchs;
        } else if (res.data && Array.isArray(res.data.content)) {
          matchsArray = res.data.content;
        } else {
          console.warn('Format API matchs inconnu :', res.data);
          toast.warn('Format de données de matchs incorrect');
          matchsArray = [];
        }
        setMatchs(matchsArray);
      })
      .catch(error => {
        console.error('Erreur chargement matchs :', error);
        setMatchs([]);
        toast.error('Impossible de charger les matchs');
      });
  };

  const ajouterOuModifierMatch = () => {
    const { date, heureDebut, heureFin, equipe, adversaire, terrain } = nouveauMatch;
    if (!date || !heureDebut || !heureFin || !equipe || !adversaire || !terrain) {
      toast.warn('Tous les champs sont obligatoires');
      return;
    }
    if (heureDebut >= heureFin) {
      toast.warn('L’heure de fin doit être après l’heure de début');
      return;
    }
    if (nouveauMatch.id === null) {
      axios.post('/api/matchs', nouveauMatch)
        .then(() => {
          toast.success('Match ajouté');
          resetForm();
          chargerMatchs();
        })
        .catch(() => toast.error('Erreur ajout match'));
    } else {
      axios.put(`/api/matchs/${nouveauMatch.id}`, nouveauMatch)
        .then(() => {
          toast.success('Match modifié');
          resetForm();
          chargerMatchs();
        })
        .catch(() => toast.error('Erreur modification match'));
    }
  };

  const supprimerMatch = (id) => {
    if (!window.confirm('Supprimer ce match ?')) return;
    axios.delete(`/api/matchs/${id}`)
      .then(() => {
        toast.info('🗑️ Match supprimé');
        chargerMatchs();
      })
      .catch(() => toast.error('Erreur suppression'));
  };

  const startEdit = (m) => {
    setNouveauMatch({ ...m });
    window.scrollTo({ top: 0, behavior: 'smooth' });
  };

  const resetForm = () => {
    setNouveauMatch({
      id: null,
      date: '',
      heureDebut: '',
      heureFin: '',
      equipe: '',
      adversaire: '',
      terrain: ''
    });
  };

  /* ---------- rendu ---------- */
  return (
    <div className="gerer-matchs-container gerer-matchs-grid">

      {/* Colonne 1 : navigation */}
      <div className="gerer-matchs-col">
        <h2>Gérer les matchs</h2>
        <button onClick={() => navigate('/')} className="btn btn-outline-secondary mb-2">
          ⬅ Retour
        </button>
        <button onClick={() => navigate('/calendrier')} className="btn btn-outline-secondary">
          Calendrier des matchs
        </button>
      </div>

      {/* Colonne 2 : formulaire */}
      <div className="gerer-matchs-col gerer-matchs-card">
        <h4>{nouveauMatch.id === null ? 'Ajouter un match' : 'Modifier le match'}</h4>
        <div className="row g-2">
          <div className="col-md-4">
            <input
              type="date"
              className="form-control"
              value={nouveauMatch.date}
              onChange={e => setNouveauMatch({ ...nouveauMatch, date: e.target.value })}
            />
          </div>
          <div className="col-md-4">
            <input
              type="time"
              className="form-control"
              value={nouveauMatch.heureDebut}
              onChange={e => setNouveauMatch({ ...nouveauMatch, heureDebut: e.target.value })}
            />
          </div>
          <div className="col-md-4">
            <input
              type="time"
              className="form-control"
              value={nouveauMatch.heureFin}
              onChange={e => setNouveauMatch({ ...nouveauMatch, heureFin: e.target.value })}
            />
          </div>
          <div className="col-md-6">
            <input
              type="text"
              placeholder="Équipe"
              className="form-control"
              value={nouveauMatch.equipe}
              onChange={e => setNouveauMatch({ ...nouveauMatch, equipe: e.target.value })}
            />
          </div>
          <div className="col-md-6">
            <input
              type="text"
              placeholder="Adversaire"
              className="form-control"
              value={nouveauMatch.adversaire}
              onChange={e => setNouveauMatch({ ...nouveauMatch, adversaire: e.target.value })}
            />
          </div>
          <div className="col-md-6">
            <input
              type="text"
              placeholder="Terrain"
              className="form-control"
              value={nouveauMatch.terrain}
              onChange={e => setNouveauMatch({ ...nouveauMatch, terrain: e.target.value })}
            />
          </div>
        </div>
        <div className="mt-3">
          <button
            onClick={ajouterOuModifierMatch}
            className={`btn ${nouveauMatch.id === null ? 'btn-success' : 'btn-primary'} me-2`}
          >
            {nouveauMatch.id === null ? 'Ajouter' : 'Enregistrer'}
          </button>
          {nouveauMatch.id !== null &&
            <button onClick={resetForm} className="btn btn-secondary">Annuler</button>
          }
        </div>
      </div>

      {/* Colonne 3 : tableau */}
      <div className="gerer-matchs-col">
        <div className="table-responsive">
          <table className="table gerer-matchs-table align-middle">
            <thead>
              <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Début</th>
                <th>Fin</th>
                <th>Équipe</th>
                <th>Adversaire</th>
                <th>Terrain</th>
                <th>Détails</th>
                <th />
              </tr>
            </thead>
            <tbody>
              {Array.isArray(matchs) ? (
                matchs.length > 0 ? (
                  matchs.map(m => (
                    <tr key={m.id}>
                      <td>{m.id}</td>
                      <td>{m.date}</td>
                      <td>{m.heureDebut}</td>
                      <td>{m.heureFin}</td>
                      <td>{m.equipe}</td>
                      <td>{m.adversaire}</td>
                      <td>{m.terrain}</td>
                      <td>
                        <button
                          className="btn btn-sm btn-outline-info"
                          onClick={() => navigate(`/matchs/${m.id}`)}
                        >
                          Voir
                        </button>
                      </td>
                      <td>
                        <button onClick={() => startEdit(m)} className="btn btn-sm btn-outline-primary me-2">✏️</button>
                        <button onClick={() => supprimerMatch(m.id)} className="btn btn-sm btn-outline-danger">🗑️</button>
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr><td colSpan="9" className="text-center">Aucun match pour le moment</td></tr>
                )
              ) : (
                <tr><td colSpan="9" className="text-center">Erreur de chargement des données</td></tr>
              )}
            </tbody>
          </table>
        </div>
      </div>

      <ToastContainer position="top-right" autoClose={2500} hideProgressBar />
    </div>
  );
}
