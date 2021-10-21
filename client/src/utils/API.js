const axios = require('axios')
const baseUrl = "http://localhost:8080/";

const signIn = async (id, password) => {
    const data = {id: id, password: password}
    const res = await axios.post(baseUrl + "jplan/signin", data)

    /* 리턴되는 토큰과 로그인 성공 알려주는 로직 추가 */

    return res.status === 200;
}

const signUp = async (id, password, name, email) => {
    const data = {id: id, password: password, name: name, email: email}
    const res = await axios.post(baseUrl + "jplan/signup", data)
    console.log(res)
}

export default {signIn, signUp}