const axios = require('axios')
const jwt = require('jsonwebtoken')
const baseUrl = "http://localhost:8080/jplan/memberservice/";

const isToken = () => {
    return !!window.localStorage.getItem('access-token');
}

const getMemberId = () => {
    const {userId} = jwt.decode(window.localStorage.getItem('access-token'))
    return userId
}

const getMemberData = async (memberId) => {

    const params = {id: memberId}

    const res = await axios.get(baseUrl + "member", {params})
    return res.data
}

const getMembersData = async () => {
    const res = await axios.get(baseUrl + "members")
    return res.data
}

const addFriend = async (myId, friendId) => {

    const body = {memberId: myId, friendId: friendId,}
    let res

    try {
        res = await axios.post(baseUrl + "friend", body)
    } catch (e) {
        console.log("Check Info {}, {}", body, res)
    }
    // 일단 true 반환
    return true
}

export default {getMemberId, getMemberData, isToken, addFriend, getMembersData}