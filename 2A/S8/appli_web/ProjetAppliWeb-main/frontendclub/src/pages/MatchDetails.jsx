import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './MatchDetails.css';

export default function MatchDetails() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [match, setMatch] = useState(null);
  const [joueursEquipe, setJoueursEquipe] = useState([]);

  useEffect(() => {
    axios.get(`/api/matchs/${id}`)
      .then(res => setMatch(res.data))
      .catch(() => {
        toast.error("Impossible de charger les détails du match");
        navigate('/matchs');
      });
  }, [id, navigate]);

  useEffect(() => {
    if (match) {
      axios.get('/api/joueurs')
        .then(res => {
          const filtrés = res.data.filter(j => j.equipe === match.equipe);
          setJoueursEquipe(filtrés);
        })
        .catch(() => toast.error("Impossible de charger la liste des joueurs"));
    }
  }, [match]);

  if (!match) {
    return <div className="match-details loading">Chargement des détails…</div>;
  }

  return (
    <div className="match-details container">
      <button className="btn-back" onClick={() => navigate('/matchs')}>← Retour</button>

      <div className="row details-row">
        {/* Colonne 1 : Infos du match */}
        <div className="col-md-4">
          <div className="card match-card">
            <h2 className="match-title">Match #{match.id}</h2>
            <div className="match-info">
              <div><strong>Date :</strong> {match.date}</div>
              <div><strong>Heure :</strong> {match.heureDebut} – {match.heureFin}</div>
              <div><strong>Équipe :</strong> {match.equipe}</div>
              <div><strong>Adversaire :</strong> {match.adversaire}</div>
              <div><strong>Terrain :</strong> {match.terrain ?? '—'}</div>
              <div><strong>Statut :</strong> {match.statut ?? '—'}</div>
            </div>
          </div>
        </div>

        {/* Colonne 2 : Joueurs */}
        <div className="col-md-4">
          <div className="card joueurs-card">
            <h3>Joueurs de l'équipe {match.equipe}</h3>
            {joueursEquipe.length > 0 ? (
              <ul className="list-group joueurs-list">
                {joueursEquipe.map(j => (
                  <li key={j.id} className="list-group-item joueur-item">
                    {j.nom} {j.poste && `(${j.poste})`}
                  </li>
                ))}
              </ul>
            ) : (
              <p className="no-players">Aucun joueur associé.</p>
            )}
          </div>
        </div>

        {/* Colonne 3 : Billets */}
        <div className="col-md-4">
          <div className="card billets-card">
            <h3>Billets vendus</h3>
            {match.billets.length > 0 ? (
              <table className="table billets-table">
                <thead>
                  <tr><th>ID</th><th>Catégorie</th><th>Prix (€)</th></tr>
                </thead>
                <tbody>
                  {match.billets.map(b => (
                    <tr key={b.id}>
                      <td>{b.id}</td>
                      <td>{b.categorie}</td>
                      <td>{(typeof b.prix === 'number' ? b.prix : 0).toFixed(2)}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) : (
              <p className="no-tickets">Aucun billet vendu.</p>
            )}
          </div>
        </div>
      </div>

      <ToastContainer position="top-right" autoClose={2500} hideProgressBar />
    </div>
  );
}