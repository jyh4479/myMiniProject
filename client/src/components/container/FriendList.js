import React, {useEffect, useState} from 'react'
import {memberServiceApi} from "../../utils";
import {ToolTip} from "../presentational";
import "../../styles/FriendList.scss"

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

    const addFriend = (myId, friendId) => {
        memberServiceApi.addFriend(myId, friendId).then(r => {
            console.log("run add data")
        })
    }

    const makeListView = myFriendList => {
        return myFriendList.map(item => (
                <ToolTip message="친구추가" onClick={addFriend(memberId, item.id)} direction="right">
                    <div className={'friendList'}>{item.id}</div>
                </ToolTip>
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