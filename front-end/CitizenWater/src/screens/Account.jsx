import React from 'react';
import { Pressable, StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';
import { useDispatch } from 'react-redux';
import { logout } from '../services/authService';

const Account = () => {
    const dispatch = useDispatch()

    return (
        <View style={generalStyle.view}>
            <Text style={styles.title}>Compte</Text>
            <Pressable
                onPress={() => dispatch(logout())}
            >
                <Text>Déconnexion</Text>
            </Pressable>
        </View>
    );
}

const styles = StyleSheet.create({
    title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 15
    }
})

export default Account;
