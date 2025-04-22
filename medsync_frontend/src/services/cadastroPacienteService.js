import axios from 'axios';

export const cadastrarPaciente = async (nome, email, senha, nascimento, telefone, rg) => {
  try {

    const response = await axios.post('http://localhost:7070/api/usuarios', {
      nome,
      email,
      senha,
      tipo: 'Paciente',
    });

    const usuarioId = response.data.pkId;


    const pacienteData = {
      fk_usuario: usuarioId,
      dt_nascimento: nascimento,
      ds_telefone: telefone,
      ds_rg: rg,
    };


    await axios.post('http://localhost:7070/api/pacientes', pacienteData);


    window.location.href = '/login'; 

    return response.status; 
  } catch (error) {

    throw new Error('Erro ao criar a conta. Tente novamente.');
  }
};
