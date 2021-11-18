const axios = require('axios')
const jwt = require('jsonwebtoken')
const baseUrl = "http://localhost:8080/jplan/memberservice/";

const getMemberId = () => {
    const {userId} = jwt.decode(window.localStorage.getItem('access-token'))
    return userId
}

const getMemberData = async (memberId) => {

    const params = {id: memberId}

    const res = await axios.get(baseUrl + "member", {params})
    return res.data
}

export default {getMemberId, getMemberData}