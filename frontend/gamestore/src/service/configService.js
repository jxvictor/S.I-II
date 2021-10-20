import axios from 'axios'

const apiClient = axios.create({
    baseURL: "http://localhost:8080/v2",
    withCredentials: false,
    headers: {
        Accept: 'application/json',
        'Content-Type':'application/json'
    }
})

export default apiClient