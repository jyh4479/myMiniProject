const axios = require('axios')
const baseUrl = "http://localhost:8080/";

axios.interceptors.request.use((config) => {
    console.log("req")
    console.log(config.data)
    return config
}, (error) => {
    console.log("BYE")
    return Promise.reject(error)
})

axios.interceptors.response.use((response) => {
    console.log("res")
    console.log(response.data)
    return response
}, (error) => {
    console.log("BYE")
    return Promise.reject(error)
})


const signIn = async (id, password) => {
    const data = {id: id, password: password}
    const {status} = await axios.post(baseUrl + "jplan/signin", data)

    /* 리턴되는 토큰과 로그인 성공 알려주는 로직 추가 */

    return status === 200;
}

const signUp = async (id, password, name, email) => {
    const data = {id: id, password: password, name: name, email: email}
    const res = await axios.post(baseUrl + "jplan/signup", data)
    console.log(res)
}

export default {signIn, signUp}