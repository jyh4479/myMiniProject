const axios = require('axios')
const jwt = require('jsonwebtoken')
const baseUrl = "http://localhost:8080/jplan/memberservice/";

const getMemberId = () => {
    const {userId} = jwt.decode(window.localStorage.getItem('access-token'))
    return userId
}

const getMemberData = async (userId) => {
    const res = await axios.get(baseUrl + "member")
    console.log(res)
}

export default {getMemberId, getMemberData}