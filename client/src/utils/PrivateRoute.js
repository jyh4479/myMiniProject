import React from 'react'
import {Redirect, Route} from 'react-router-dom';

//https://gaemi606.tistory.com/entry/React-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%A0%95%EB%B3%B4-%EC%97%86%EC%9D%84-%EA%B2%BD%EC%9A%B0-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%8E%98%EC%9D%B4%EC%A7%80%EB%A1%9C-redirect%ED%95%98%EA%B8%B0-react-router-PrivateRoute
//참고
const PrivateRoute = ({component: Component, ...rest}) => {
    return (
        <Route
            {...rest}
            render={props =>
                localStorage.getItem('access-token') ? (
                    <Component {...props} />
                ) : (
                    <Redirect to={{
                        pathname: '/login',
                        state: {from: props.location}
                    }}
                    />
                )
            }
        />
    )
}

export default PrivateRoute;