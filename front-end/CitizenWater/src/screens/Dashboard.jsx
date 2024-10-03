import React, { useEffect, useLayoutEffect } from 'react';
import { Image, Pressable, StyleSheet, Text, View } from 'react-native';
import logo from '../../assets/121.png'
import generalStyle from '../styles/GeneralStyle';
import SmCard from '../components/SmCard';
import { useDispatch } from 'react-redux';
import { fetchUserDatas } from '../services/userService';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons'
import styleColors from '../styles/StyleColors';
import { useNavigation } from '@react-navigation/native';

const Dashboard = () => {

    const dispatch = useDispatch()
    const navigation = useNavigation()

    useEffect(() => {
        console.log("use effect")
        
        dispatch(fetchUserDatas())
    }, [''])

    return (
        <View style={generalStyle.view}>
            <Image source={logo} style={styles.image} />
            <Text style={styles.title} >Bienvenue</Text>
            <View style={styles.notificationContainer}>
                <SmCard
                    cardStyle={styles.customCard}
                >
                    <Pressable 
                        onPress={() => navigation.navigate('Alert')} 
                        style={styles.pressableCard}
                    >
                        <Icon name={'alert-outline'} size={35} />
                        <Text style={styles.alertCounter}>1</Text>
                    </Pressable>
                </SmCard>
                <SmCard
                    cardStyle={styles.customCard}
                >
                    <Pressable 
                        onPress={() => navigation.navigate('Notification')} 
                        style={styles.pressableCard}
                    >
                        <Icon name={'bell-outline'} size={35} color={styleColors.blue2} />
                        <Text style={styles.notificationCounter}>1</Text>
                    </Pressable>
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
    },
    notificationCounter: {
        fontSize: 20,
        fontWeight: 'bold',
        textAlign: 'center',
        color: styleColors.blue2
    },
    pressableCard: {
        width: '100%',
        height: '100%',
        justifyContent: 'center',
        alignItems: 'center'
    }

})

export default Dashboard;
