import React from 'react';
import { Pressable, StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';
import { useDispatch, useSelector } from 'react-redux';
import { logout } from '../services/authService';
import CsButton from '../components/CsButton';
import styleColors from '../styles/StyleColors';
import SmCard from '../components/SmCard';
import { ROLE_SUPER_ADMIN, ROLE_USER } from '../utils/constants';

const Account = () => {
    const dispatch = useDispatch()
    const userDatas = useSelector(({user}) => user.datas)
    const {roles} = useSelector(({auth}) => auth.decodedToken)

    return (
        <View style={[generalStyle.view, styles.main]}>
            
            <View style={{flex: .5}}>
                <View style={{marginBottom: 50}}>
                    <Text style={styles.title}>Compte</Text>
                    <Text style={styles.subTitle}>{userDatas.firstname} {userDatas.lastname}</Text>
                </View>
                <SmCard >
                    {roles == ROLE_SUPER_ADMIN && <Text>Compte administrateur</Text>}
                    {roles == ROLE_USER && <Text>Compte utilisateur</Text>}
                </SmCard>
            </View>
            <CsButton
                onPress={() => dispatch(logout())}
                text={'Se déconnecter'}
                style={{marginHorizontal: 5}}
            >
            </CsButton>
        </View>
    );
}

const styles = StyleSheet.create({
    title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 15,
        marginBottom: 50,
    },
    subTitle: {
        fontSize: 28,
        fontWeight: 'bold',
        color: styleColors.blue4,
    },
    main: {
        justifyContent: 'space-between',
        paddingBottom: 130,
    }
})

export default Account;
