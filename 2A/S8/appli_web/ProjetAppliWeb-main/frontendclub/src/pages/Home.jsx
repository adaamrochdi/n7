import React from 'react';
import './Home.css';
import logo from '../assets/logo.png';

function Home() {
  return (
    <div className="home-container">
      {/* Bandeau décoratif */}
      <div className="decor-bar"></div>

      <header className="home-header">
        <img src={logo} alt="Club Logo" className="club-logo" />
        <h1>Bienvenue dans le Système de Gestion du Club</h1>
        <p>Suivi des joueurs, matchs, entraînements et plus !</p>

        {/* Effet de vague SVG */}
        <div className="header-wave">
          <svg viewBox="0 0 500 150" preserveAspectRatio="none">
            <path d="M0.00,49.98 C150.00,150.00 350.00,-50.00 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" style={{ fill: "#f4f4f9" }}></path>
          </svg>
        </div>
      </header>

      <nav className="home-nav">
        <ul>
          <li><a href="/joueurs" className="nav-link">Gérer les Joueurs</a></li>
          <li><a href="/staff" className="nav-link">Gérer le Staff</a></li>
          <li><a href="/contracts" className="nav-link">Gérer les Contrats</a></li>
          <li><a href="/matchs" className="nav-link">Gerer Les Matchs</a></li>
          <li><a href="/trainings" className="nav-link">Sessions d’Entraînement</a></li>
          <li><a href="/tickets" className="nav-link">Vente de Billets</a></li>
          <li><a href="/users" className="nav-link">Gestion des Utilisateurs</a></li>
        </ul>
      </nav>
    </div>
  );
}

export default Home;
