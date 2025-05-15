import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:7070', // ou a porta do seu backend Spring Boot
});

export default api;
