import React, { useEffect, useLayoutEffect } from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import logo from '../../assets/121.png'
import generalStyle from '../styles/GeneralStyle';
import SmCard from '../components/SmCard';
import { useDispatch } from 'react-redux';
import { fetchUserDatas } from '../services/userService';

const Dashboard = () => {

    const dispatch = useDispatch()

    useEffect(() => {
        console.log("use effect")
        
        dispatch(fetchUserDatas())
    }, [''])

    return (
        <View style={generalStyle.view}>
            <Image source={logo} style={styles.image} />
            <Text style={styles.title} >Bienvenue</Text>
            <View style={styles.notificationContainer}>
                {/* <View style={styles.alertBox}>
                    <Text>Wesh</Text>
                </View> */}
                <SmCard
                    cardStyle={styles.customCard}
                >
                    <Text>Wesh</Text>
                </SmCard>
            </View>

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
        margin: 10
    },
    notificationContainer: {
        marginTop: 25,
        flex: .2,
        flexDirection: 'row'
    },
    alertBox: {
        backgroundColor: '#fff',
        flex: 1,
        margin: 10,
        padding: 5,
        borderRadius: 10,
        elevation: 3
    },
    customCard: {
        flex: .5,
        justifyContent: 'center',
        alignItems: 'center'
    }

})

export default Dashboard;
