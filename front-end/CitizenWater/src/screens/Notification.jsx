import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';

const Notification = () => {
    return (
        <View style={generalStyle.view}>
            <Text style={styles.title}>Notifications & Recommandations</Text>
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

export default Notification;
