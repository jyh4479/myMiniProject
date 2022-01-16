import React, {useEffect, useState} from 'react'
import {memberServiceApi} from "../../utils";
import {ToolTip} from "../presentational";
import "../../styles/FriendList.scss"
import ChatServiceApi from "../../utils/ChatServiceApi";

const FriendList = () => {

    const memberId = memberServiceApi.getMemberId()
    const [myFriendList, setMyFriendList] = useState([])

    // document.addEventListener("contextmenu", (event) => {
    //     console.log("ggg")
    //     event.preventDefault()
    // })

    useEffect(() => {
        fetchData(memberId).then(r => {
            console.log("run fetchData")
        })
    }, [memberId])

    const fetchData = async (memberId) => {
        const {friendList} = await memberServiceApi.getMemberData(memberId)
        friendList ? setMyFriendList(friendList.dataList) : setMyFriendList([])

        console.log(friendList)
    }

    const addChatRoom = (myId, friendId) => {
        ChatServiceApi.addChatRoom(myId, friendId).then(r => {
            console.log("run add data")
        })
    }

    const makeListView = myFriendList => {
        return myFriendList.map(item => (
                <ToolTip id={item.id} message="채팅방 만들기" onClick={() => addChatRoom(memberId, item.id)} direction="right">
                    <div id={item.id} className={'friendList'}>{item.name}</div>
                </ToolTip>
            )
        )
    }

    return (
        <>
            {myFriendList !== null ? (
                <div className={'friendListContainer'}>
                    {makeListView(myFriendList)}
                </div>
            ) : (
                <div> List가 없습니다. </div>
            )}
        </>
    )
}

export default FriendList