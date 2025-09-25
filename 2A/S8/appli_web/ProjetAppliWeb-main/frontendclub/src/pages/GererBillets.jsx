// frontendclub/src/pages/GererBillets.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';

export default function GererBillets() {
  const [billets, setBillets] = useState([]);
  const [form, setForm] = useState({ matchId: '', categorie: '', prix: '' });
  const [editingId, setEditingId] = useState(null);

  // 1. Chargement initial
  useEffect(() => {
    fetchBillets();
  }, []);

  const fetchBillets = async () => {
    try {
      const { data } = await axios.get('/api/tickets');
      setBillets(data);
    } catch (err) {
      toast.error("Erreur lors du chargement des billets");
    }
  };

  // 2. Soumission du formulaire (création ou mise à jour)
  const handleSubmit = async e => {
    e.preventDefault();
    try {
      if (editingId) {
        await axios.put(`/api/tickets/${editingId}`, {
          matchId: +form.matchId,
          categorie: form.categorie,
          prix: +form.prix,
        });
        toast.success("Billet mis à jour");
      } else {
        await axios.post('/api/tickets', {
          matchId: +form.matchId,
          categorie: form.categorie,
          prix: +form.prix,
        });
        toast.success("Billet ajouté");
      }
      setForm({ matchId: '', categorie: '', prix: '' });
      setEditingId(null);
      fetchBillets();
    } catch (err) {
      toast.error("Échec de l'enregistrement");
    }
  };

  // 3. Préparer la mise à jour
  const startEdit = billet => {
    setEditingId(billet.id);
    setForm({
      matchId: billet.match.id ?? billet.match_id, // selon votre JSON
      categorie: billet.categorie,
      prix: billet.prix,
    });
  };

  // 4. Suppression
  const handleDelete = async id => {
    if (!window.confirm("Supprimer ce billet ?")) return;
    try {
      await axios.delete(`/api/tickets/${id}`);
      toast.success("Billet supprimé");
      fetchBillets();
    } catch {
      toast.error("Échec de la suppression");
    }
  };

  return (
    <div className="container mt-4">
      <h2>Vente de Billets</h2>

      {/* Formulaire */}
      <form onSubmit={handleSubmit} className="mb-4">
        <div className="row g-2">
          <div className="col">
            <input
              type="number"
              className="form-control"
              placeholder="Match ID"
              value={form.matchId}
              onChange={e => setForm({ ...form, matchId: e.target.value })}
              required
            />
          </div>
          <div className="col">
            <input
              type="text"
              className="form-control"
              placeholder="Catégorie"
              value={form.categorie}
              onChange={e => setForm({ ...form, categorie: e.target.value })}
              required
            />
          </div>
          <div className="col">
            <input
              type="number"
              step="0.01"
              className="form-control"
              placeholder="Prix (€)"
              value={form.prix}
              onChange={e => setForm({ ...form, prix: e.target.value })}
              required
            />
          </div>
          <div className="col-auto">
            <button type="submit" className="btn btn-primary">
              {editingId ? 'Mettre à jour' : 'Ajouter'}
            </button>
            {editingId && (
              <button
                type="button"
                className="btn btn-secondary ms-2"
                onClick={() => {
                  setEditingId(null);
                  setForm({ matchId: '', categorie: '', prix: '' });
                }}
              >
                Annuler
              </button>
            )}
          </div>
        </div>
      </form>

      {/* Liste des billets */}
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Match ID</th>
            <th>Catégorie</th>
            <th>Prix</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {billets.map(b => (
            <tr key={b.id}>
              <td>{b.id}</td>
              <td>{b.match?.id ?? b.match_id}</td>
              <td>{b.categorie}</td>
              <td>{ (b.prix ?? 0).toFixed(2) } €</td>
              <td>
                <button
                  className="btn btn-sm btn-outline-secondary me-2"
                  onClick={() => startEdit(b)}
                >
                  Éditer
                </button>
                <button
                  className="btn btn-sm btn-outline-danger"
                  onClick={() => handleDelete(b.id)}
                >
                  Supprimer
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
