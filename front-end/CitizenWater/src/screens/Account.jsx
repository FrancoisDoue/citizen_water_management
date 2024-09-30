import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';

const Account = () => {
    return (
        <View style={generalStyle.view}>
            <Text style={styles.title}>Compte</Text>
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
