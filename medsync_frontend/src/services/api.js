import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:7070',
});

export default api;
