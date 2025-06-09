import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';

import Login from './pages/login';
//import Cadastro from './pages/cadastro';
import CadastroPaciente from './pages/cadastro_paciente';
import HomeAdministrativo from './pages/homeAdministrativo';
import CadastroMedicoForm from './pages/cadastro_medico';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/login" replace />} />
        <Route path="/login" element={<Login />} />
        {/* <Route path="/cadastro" element={<Cadastro />} /> */}
        <Route path="/cadastro-paciente" element={<CadastroPaciente />} />
        <Route path="/cadastro-medico" element={<CadastroMedicoForm />} />
        <Route path="/home-administrativo" element={<HomeAdministrativo />} />
      </Routes>
    </Router>
  );
};

export default App;
