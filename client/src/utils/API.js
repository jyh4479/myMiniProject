const axios = require('axios')
const baseUrl = "http://localhost:8080/";

const signIn = async (id, password) => {
    const data = {id: id, password: password}
    const res = await axios.post(baseUrl + "jplan/signin", data)
    console.log(res)
}

const signUp = async (id, password, name, email) => {
    const data = {id: id, password: password, name: name, email: email}
    const res = await axios.post(baseUrl + "jplan/signup", data)
    console.log(res)
}

export default {signIn, signUp}