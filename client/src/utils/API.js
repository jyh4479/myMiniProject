const axios = require('axios')
const baseUrl = "http://localhost:8080/";

const signIn = async (id, password) => {
    const data = {id: id, password: password}
    const res = await axios.post(baseUrl + "test/get", data)
}

export default {signIn}