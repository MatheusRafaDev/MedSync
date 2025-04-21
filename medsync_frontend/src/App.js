import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/login';
import Cadastro from './pages/cadastro';
import CadastroPaciente from './pages/cadastro_paciente';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/cadastro_paciente" element={<CadastroPaciente />} />
      </Routes>
    </Router>
  );
};

export default App;
