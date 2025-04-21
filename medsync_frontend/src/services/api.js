import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // ou a porta do seu backend Spring Boot
});

export default api;
