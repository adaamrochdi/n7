// src/pages/CalendrierMatchs.jsx
import React, { useEffect, useState } from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import axios from 'axios';
import { parseISO, setHours, setMinutes } from 'date-fns';
import { useNavigate } from 'react-router-dom';

const localizer = momentLocalizer(moment);

export default function CalendrierMatchs() {
  const [events, setEvents] = useState([]);
  const [currentDate, setCurrentDate] = useState(new Date());
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('/api/matchs')
      .then(res => {
        const matchs = res.data.map(match => {
          const date = parseISO(match.date);
          const [hDeb, mDeb] = match.heureDebut.split(':').map(Number);
          const [hFin, mFin] = match.heureFin.split(':').map(Number);
          const start = setHours(setMinutes(date, mDeb), hDeb);
          const end = setHours(setMinutes(date, mFin), hFin);

          return {
            title: `${match.equipe} vs ${match.adversaire}`,
            start,
            end,
            allDay: false,
          };
        });
        setEvents(matchs);
      })
      .catch(() => {
        toast.error('Impossible de charger les matchs pour le calendrier');
      });
  }, []);

  return (
    <div style={{ height: '80vh', padding: '2rem' }}>
      <h2>Calendrier des matchs</h2>
      <button onClick={() => navigate('/matchs')} style={{ marginBottom: '1rem' }}>
        ⬅ Retour à la liste
      </button>
      <Calendar
        localizer={localizer}
        events={events}
        startAccessor="start"
        endAccessor="end"
        date={currentDate}
        onNavigate={date => setCurrentDate(date)}
        views={['month', 'week', 'day']}
        defaultView="month"
        style={{ height: '100%' }}
      />
    </div>
  );
}
