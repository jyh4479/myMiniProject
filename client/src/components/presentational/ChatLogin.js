import React, {useState} from "react";
import '../../styles/ChatLogin.scss'

function ChatLogin({handleOnSubmit}) {
    const [name, setName] = useState("");

    const handleOnChange = (e) => {
        setName(e.target.value);
    };

    const handleSubmit = () => {
        handleOnSubmit(name);
    };

    return (
        <div className={'ChatLoginContainer'}>
            <form className={'ChatLoginForm'} onSubmit={handleSubmit}>
                <div className={'ChatLoginTitle'}> Kafka Chat</div>
                <button className={'ChatLoginButton'} type="submit">Go!</button>
                <input className={'ChatLoginInput'}
                       placeholder="사용할 닉네임을 입력하세요."
                       value={name}
                       onChange={handleOnChange}
                />
            </form>
        </div>
    );
}

export default ChatLogin;