import React from "react";
import '../../styles/Chat.scss'

const Chat = props => {

    const {messages, currentUser} = props

    const formattingTimestamp = timestamp => {
        const date = new Date(timestamp);
        let hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
        let min =
            date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();
        return `${hour}:${min}`;
    };

    return (
        <div className='ChatBox'>
            {messages.map((msg) => (
                <li
                    className={`ChatBubble ${
                        msg.author === currentUser.name ? "Send" : "Receive"
                    }`}
                >
                    <span>{msg.author}</span>
                    <p>{msg.content}</p>
                    <span>{formattingTimestamp(msg.timestamp)}</span>
                </li>
            ))}
        </div>
    );
}

export default Chat;