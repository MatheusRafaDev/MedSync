import React, { useState } from "react";
import api from "../services/api";
import { Navigate } from "react-router-dom";

function homeAdministrativo() {
    
    const navigate = Navigate();

    return (
        <section>

            <h2> Menu administrativo: </h2>    
            
            <div>                
                <button onClick={() => navigate("/cadastro")}>Cadastro Usuário</button>           
                <button onClick={() => navigate("/login")}>Cadastro Consulta</button>           
                <button onClick={() => navigate("/login")}>Lista de Usuário</button>           
                <button onClick={() => navigate("/login")}>Lista de Médicos</button>           
            </div>

        </section>
    )
}