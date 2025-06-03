import React, { useState } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Card, CardContent } from "@/components/ui/card";

export default function CadastroMedicoForm() {
  const [form, setForm] = useState({
    nome: "",
    crm: "",
    especialidade: "",
    email: "",
    senha: "",
    status: "ativo",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleStatusChange = (e) => {
    setForm({ ...form, status: e.target.value });
  };

  const handleSubmit = () => {
    // Lógica de envio aqui
    console.log("Médico salvo:", form);
  };

  return (
    <div className="max-w-2xl mx-auto p-6">
      <Card className="shadow-xl">
        <CardContent className="p-6 space-y-6">
          <h2 className="text-2xl font-bold">Cadastro Médico</h2>

          <div className="space-y-2">
            <Label htmlFor="nome">Nome Completo</Label>
            <Input name="nome" id="nome" value={form.nome} onChange={handleChange} />
          </div>

          <div className="grid grid-cols-2 gap-4">
            <div className="space-y-2">
              <Label htmlFor="crm">CRM</Label>
              <Input name="crm" id="crm" value={form.crm} onChange={handleChange} />
            </div>
            <div className="space-y-2">
              <Label htmlFor="especialidade">Especialidade</Label>
              <Input
                name="especialidade"
                id="especialidade"
                value={form.especialidade}
                onChange={handleChange}
              />
            </div>
          </div>

          <div className="space-y-2">
            <Label htmlFor="email">E-mail</Label>
            <Input name="email" id="email" type="email" value={form.email} onChange={handleChange} />
          </div>

          <div className="space-y-2">
            <Label htmlFor="senha">Senha</Label>
            <Input name="senha" id="senha" type="password" value={form.senha} onChange={handleChange} />
          </div>

          <div className="space-y-2">
            <Label>Status Ativo</Label>
            <div className="flex items-center gap-4">
              <label className="flex items-center gap-1">
                <input
                  type="radio"
                  name="status"
                  value="ativo"
                  checked={form.status === "ativo"}
                  onChange={handleStatusChange}
                />
                Ativo
              </label>
              <label className="flex items-center gap-1">
                <input
                  type="radio"
                  name="status"
                  value="inativo"
                  checked={form.status === "inativo"}
                  onChange={handleStatusChange}
                />
                Inativo
              </label>
            </div>
          </div>

          <div className="flex gap-4 justify-start pt-4">
            <Button onClick={handleSubmit}>Salvar novo</Button>
            <Button variant="secondary">Editar</Button>
            <Button variant="secondary">Ativar/Inativar</Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}
