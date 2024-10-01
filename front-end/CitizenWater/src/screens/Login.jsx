import React, { useLayoutEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { useDispatch, useSelector } from 'react-redux';
import App from '../../App';

const Login = () => {

    
    const dispatch = useDispatch();
    const token = useSelector(state => state.authentication.token)
    const [logged, setLogged] = useState(token != null)

    useLayoutEffect(() => {
        setLogged(token != null)
    }, [token])

    if (logged) {
        return <App></App>
    }

    return (
        <View>
            <Text>wesh</Text>
        </View>
    );
}

const styles = StyleSheet.create({})

export default Login;
