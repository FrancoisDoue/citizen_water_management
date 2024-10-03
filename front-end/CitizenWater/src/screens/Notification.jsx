import React from 'react';
import { FlatList, Image, StyleSheet, Text, View } from 'react-native';
import generalStyle from '../styles/GeneralStyle';
import { useSelector } from 'react-redux';
import styleColors from '../styles/StyleColors';
import SmCard from '../components/SmCard';

const Notification = () => {

    const notifications = useSelector(({user}) => user?.datas?.notifications) || null
    

    return (
        <View style={generalStyle.view}>
            <Text style={styles.title}>Notifications & Recommandations</Text>
            <FlatList 
                data={notifications || [] }
                fadingEdgeLength={10}
                numColumns={1}
                
                contentContainerStyle={{paddingBottom: 100}}
                ListEmptyComponent={
                    <View style={styles.emptyNotificationBox}>
                        <Text style={styles.emptyNotificationText}>Vous n'avez aucune notification</Text>
                    </View>
                }
                keyExtractor={item => item.id}
                renderItem={({item}) => 
                    <SmCard cardStyle={{paddingHorizontal: 0}}>
                        <View style={styles.listItem}>
                            <View style={styles.cardTitle}>
                                <View style={{flex: .75}}>
                                    <Text style={styles.cardTitleMain}> {item.title} </Text>
                                </View>
                                <View style={{flex: .25}}>
                                    <Text style={styles.cardTitleDate}>{new Date(Date.parse(item.createdDate)).toLocaleDateString()}</Text>
                                </View>
                            </View>
                            <Image style={styles.listImage} source={{uri: item?.imageUrl}} resizeMode='' />
                            <View style={styles.cardContent}>
                                <Text style={styles.messageContent}>
                                    {item.message}
                                </Text>
                            </View>
                        </View>
                        {/* <Text>{JSON.stringify(item)}</Text> */}
                    </SmCard>
                }
            />
        </View>
    );
}

const styles = StyleSheet.create({
    title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'black',
        marginTop: 15
    },
    emptyNotificationBox: {
        height: 300,
        alignItems: 'center',
        justifyContent: 'center',
    },
    emptyNotificationText: {
        fontSize: 20,
        color: styleColors.blue1
    },
    listItem: {
        flex: 1,
    },
    listImage: {
        width: '100%',
        height: 175,
    },
    cardTitle: {
        padding: 15,
        flexDirection: 'row'
    },
    cardTitleMain: {
        fontSize: 25,
        fontWeight: '600',
        color: styleColors.blue3,
    },
    cardTitleDate: {
        fontSize: 15,
        color: styleColors.blue3,
        textAlign: 'right'
    },
    cardContent: {
        padding: 15,
    },
    messageContent: {
        fontSize: 17,
        color: styleColors.blue4,
        textAlign: 'justify',
    }

})

export default Notification;
