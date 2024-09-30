import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import logo from '../../assets/121.png'
import generalStyle from '../styles/GeneralStyle';

const Dashboard = () => {
    return (
        <View style={generalStyle.view}>
            <Image source={logo} style={styles.image} />
            <Text style={styles.title} >Bienvenue</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    image: {
        width: 220,
        height: 100,
        marginLeft:10,
        marginTop:5
    },
    title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 10
    }
})

export default Dashboard;
