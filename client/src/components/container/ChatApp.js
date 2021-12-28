import React, {useEffect, useState} from "react";
import {memberServiceApi} from "../../utils";
import "../../styles/ChatApp.scss"


const ChatApp = () => {

    const memberId = memberServiceApi.getMemberId()
    const [roomList, setRoomList] = useState(null)

    // const [messages, setMessages] = useState(null);
    // const [user, setUser] = useState(null);

    useEffect(() => {
        fetchData(memberId).then(r => {
            console.log("run fetchData")
        })
    }, [memberId])

    const fetchData = async (memberId) => {
        const {chattingRoomList} = await memberServiceApi.getMemberData(memberId)
        setRoomList(chattingRoomList.dataList)
    }

    // const onMessageReceived = (msg) => {
    //     console.log("New Message Received!!", msg);
    //     setMessages(messages.concat(msg));
    // };

    // const handleLoginSubmit = (name) => {
    //     setUser({name: name, color: randomColor()});
    // };

    // const handleMessageSubmit = (msg) => {
    //     chatServiceApi
    //         .sendMessage(memberId, msg)
    //         .then((res) => {
    //             console.log("sent", res);
    //         })
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // };
    //
    // const randomColor = () => {
    //     return "#" + Math.floor(Math.random() * 0xffffff).toString(16);
    // };
    //
    // const onConnected = () => {
    //     chatServiceApi
    //         .sendMessage("connect", memberId + " 님이 들어왔습니다.")
    //         .then((res) => {
    //             console.log("connected!", res);
    //         })
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // }
    // const onDisconnected = () => {
    //     chatServiceApi
    //         .sendMessage("disconnect", memberId + " 님이 나갔습니다.")
    //         .then((res) => {
    //             console.log("disconnected!", res);
    //         })
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // }

    const makeListView = dataList => {
        return dataList.map(item => (
            <button
                onClick={() => newWindow(`http://localhost:5000/chatroom/${item.id}`, memberId)}> {item.id} </button>))
    }

    const newWindow = (url, user) => {
        console.log(url)
        window.open(url, user, 'width=430,height=500,location=no,status=no,scrollbars=yes');
        return true
    }

    return (
        <>
            {/*{user !== null ? (*/}


            {roomList !== null ? (
                <div> {makeListView(roomList)} </div>
            ) : (
                <div> List가 없습니다. </div>
            )}


            {/*<div className="ChatContainer">*/}
            {/*    /!*<button onClick={() => newWindow("http://localhost:5000/", user)}>button</button>*!/*/}
            {/*    <SockJsClient*/}
            {/*        url={"http://localhost:2821/test/"}*/}
            {/*        topics={["/topic/group"]}*/}
            {/*        onConnect={onConnected}*/}
            {/*        onDisconnect={onDisconnected}*/}
            {/*        onMessage={(msg) => onMessageReceived(msg)}*/}
            {/*        debug={false}*/}
            {/*    />*/}
            {/*    <Chat messages={messages} currentUser={memberId}/>*/}
            {/*    <ChatInput handleOnSubmit={handleMessageSubmit}/>*/}
            {/*</div>*/}


            {/*) : (*/}
            {/*    <ChatLogin handleOnSubmit={handleLoginSubmit}/>*/}
            {/*)}*/}
        </>
    );
}

export default ChatApp;