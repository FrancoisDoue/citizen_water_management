import React, { useEffect, useLayoutEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { useDispatch, useSelector } from 'react-redux';
import Navigator from '../Navigator';
import generalStyle from '../styles/GeneralStyle';
import styleColors from '../styles/StyleColors';
import CsTextInput from '../components/CsTextInput';
import CsButton from '../components/CsButton';
import { initAuth, login } from '../services/authService';
import { selectIsLogged } from '../store/authSlice';

const Login = () => {
    const dispatch = useDispatch()
    const isLogged = useSelector(selectIsLogged)
    const [identifier, setIdentifier] = useState('')
    const [password, setPassword] = useState('')

    const handleSubmit = () => {
        console.log('submit login')
        const credentials = {
            email: identifier,
            password: password,
        }
        dispatch(login(credentials))
    }

    useEffect(() => {
        console.log("login screen - useLayoutEffect")
        dispatch(initAuth())
    }, [isLogged])

    if (isLogged) {
        return (
            <Navigator />
        )
    }

    return (
        <View style={generalStyle.view}>
            <View style={styles.header}>
                <Text style={styles.headerText}>Connexion</Text>
            </View>
            <View style={styles.main}>
                <CsTextInput
                    style={styles.csInputStyle}
                    label={'Identifiant'}
                    placeholder={'example@mail.fr'}
                    value={identifier}
                    onChangeText={setIdentifier}
                />
                <CsTextInput
                    style={styles.csInputStyle}
                    label={'Password'}
                    value={password}
                    onChangeText={setPassword}
                    password
                />
                <View style={styles.btnGroup}>
                    <CsButton
                        style={{width: '75%'}}
                        text={'Se connecter'}
                        onPress={handleSubmit}
                    />
                </View>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    header: {
        flex: .25,
    },
    headerText: {
        marginHorizontal: 10,
        marginTop: 20,
        fontSize: 35,
        fontWeight: '600',
        color: styleColors.blue4
    },
    main: {
        flex: .75,
    },
    csInputStyle: {
        paddingBottom: 20,
    },
    btnGroup: {
        alignItems: 'center',
        marginTop: 75,
    },
})

export default Login;
