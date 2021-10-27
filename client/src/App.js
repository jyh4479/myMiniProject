import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import {HomePage, LoginPage, SignUpPage} from "./pages";

const App = () => {

    /* 해당 로직 변경 필요 --> 단순 로그인페이지 리턴으로 라우팅이 안먹힘 */
    if (!window.localStorage.getItem('access-token') && window.location.pathname !== '/login')
        return <LoginPage/>

    return (
        <Router>
            <Switch>
                <Route exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
            </Switch>
        </Router>
    );
}

export default App;
