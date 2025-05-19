import { useEffect, useState } from "react";
import axios from "axios";

const ProntuariosPaciente = ({ idPaciente, idMedico }) => {
  const [prontuarios, setProntuarios] = useState([]);
  const [descricao, setDescricao] = useState("");
  const [carregando, setCarregando] = useState(true);

  useEffect(() => {
    axios.get(`/api/prontuarios/paciente/${idPaciente}`)
      .then(response => {
        setProntuarios(response.data);
        setCarregando(false);
      });
  }, [idPaciente]);

  const handleSalvar = () => {
    if (!descricao) return alert("Descrição obrigatória!");

    const novoProntuario = {
      paciente: { idPaciente },
      medico: { idMedico },
      dsDescricao: descricao
    };

    axios.post("/api/prontuarios", novoProntuario)
      .then(() => {
        setDescricao("");
        return axios.get(`/api/prontuarios/paciente/${idPaciente}`);
      })
      .then(response => setProntuarios(response.data))
      .catch(err => alert("Erro ao salvar prontuário"));
  };

  if (carregando) return <p>Carregando prontuários...</p>;

  return (
    <div className="max-w-3xl mx-auto p-4">
      <h2 className="text-2xl font-bold mb-4">Prontuários do Paciente</h2>

      <div className="mb-6">
        <textarea
          className="w-full border rounded p-2"
          placeholder="Descrição do atendimento"
          value={descricao}
          onChange={(e) => setDescricao(e.target.value)}
        />
        <button
          onClick={handleSalvar}
          className="mt-2 px-4 py-2 bg-blue-600 text-white rounded"
        >
          Salvar Prontuário
        </button>
      </div>

      <ul className="space-y-4">
        {prontuarios.map((item) => (
          <li key={item.idProntuario} className="border p-3 rounded shadow">
            <p className="text-sm text-gray-600">
              {new Date(item.dtRegistro).toLocaleString()}
            </p>
            <p className="font-semibold">Médico: {item.medico?.dsNome || "Desconhecido"}</p>
            <p>{item.dsDescricao}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProntuariosPaciente;
