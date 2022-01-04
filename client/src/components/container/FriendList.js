import React, {useEffect, useState} from 'react'
import {memberServiceApi} from "../../utils";

const FriendList = () => {

    const memberId = memberServiceApi.getMemberId()
    const [myFriendList, setMyFriendList] = useState([])

    useEffect(() => {
        fetchData(memberId).then(r => {
            console.log("run fetchData")
        })
    }, [memberId])

    const fetchData = async (memberId) => {
        const {friendList} = await memberServiceApi.getMemberData(memberId)
        setMyFriendList(friendList.dataList)
    }

    const makeListView = myFriendList => {
        return myFriendList.map(item => (
                <div>{item.id}</div>
            )
        )
    }

    return (
        <>
            {myFriendList !== null ? (
                <div> {makeListView(myFriendList)} </div>
            ) : (
                <div> List가 없습니다. </div>
            )}
        </>
    )
}

export default FriendList