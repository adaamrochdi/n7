import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import GererLesJoueurs from './pages/GererLesJoueurs';
import GererLesMatchs from './pages/GererLesMatchs';
import CalendrierMatchs from './pages/CalendrierMatchs';
import GererBillets from "./pages/GererBillets";
import MatchDetails     from './pages/MatchDetails'; 

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/joueurs" element={<GererLesJoueurs />} />
        <Route path="/matchs" element={<GererLesMatchs />} />
        <Route path="/matchs/:id"  element={<MatchDetails />} />
        <Route path="/calendrier" element={<CalendrierMatchs />} /> 
        <Route path="/tickets" element={<GererBillets />} />
        {/* Ajoutez d'autres routes ici si nécessaire */}
      </Routes>
    </Router>
  );
}

export default App;
