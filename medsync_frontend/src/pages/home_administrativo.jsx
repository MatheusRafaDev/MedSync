import React from "react";
import { useNavigate } from "react-router-dom";
import '../styles/home_administrativo.css'; 

function HomeAdministrativo() {
    const navigate = useNavigate();

    return (
        <section className="admin-home">
            <header className="admin-header">
                <h2>Menu Administrativo</h2>
                <p>Escolha uma das opções abaixo para gerenciar a clínica.</p>
            </header>

            <div className="button-container">
                <button className="admin-btn" onClick={() => navigate("/cadastro-usuario")}>
                    Cadastro de Usuário Padrão
                </button>
                <button className="admin-btn" onClick={() => navigate("/cadastro-medico")}>
                    Cadastro de Médico
                </button>
                <button className="admin-btn" onClick={() => navigate("/cadastro-paciente")}>
                    Cadastro de Paciente
                </button>
                <button className="admin-btn" onClick={() => navigate("/lista-usuarios")}>
                    Lista de Usuários
                </button>
                <button className="admin-btn" onClick={() => navigate("/lista-medicos")}>
                    Lista de Médicos
                </button>
                <button className="admin-btn" onClick={() => navigate("/agenda-consultas")}>
                    Agenda de Consultas
                </button>
                <button className="admin-btn" onClick={() => navigate("/historico-diagnosticos")}>
                    Histórico de Diagnósticos
                </button>
                <button className="admin-btn" onClick={() => navigate("/gerenciar-consultas")}>
                    Gerenciar Consultas
                </button>
                <button className="admin-btn" onClick={() => navigate("/cadastro-usuario-interno")}>
                    Cadastro de Usuário Interno
                </button>
            </div>

            <footer className="admin-footer">
                <p>&copy; 2025 Sistema de Gestão de Clínica Médica</p>
            </footer>
        </section>
    );
}

export default HomeAdministrativo;
