import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Dashboard from "./screens/Dashboard";
import { NavigationContainer, useNavigation } from "@react-navigation/native";
import { StyleSheet } from "react-native";
import Consumption from "./screens/Consumption";
import Alert from "./screens/Alert";
import Notification from "./screens/Notification";
import Account from "./screens/Account";
import MaterialCommunityIcon from 'react-native-vector-icons/MaterialCommunityIcons'
import FontAwesome6 from 'react-native-vector-icons/FontAwesome6'
import MaterialIcons from 'react-native-vector-icons/MaterialIcons'
import StyleColors from "./styles/StyleColors";
import { useEffect, useLayoutEffect } from "react";
import { useDispatch } from "react-redux";
import { fetchUserDatas } from "./services/userService";



const Navigator = () => {

    const dispatch = useDispatch()
    const Tab = createBottomTabNavigator();

    useEffect(() => {
        console.log("use effect")
        dispatch(fetchUserDatas())
    }, [])
    // const Stack = createNativeStackNavigator();

    // function MyStackNavigator() {
    //   return (
    //     <Stack.Navigator>
    //       <Stack.Screen name="HomeScreen" component={HomeScreen} options={{headerShown: false}}/>
    //       {/* <Stack.Screen name="DetailsPokemon" component={DetailsPokemonScreen} /> */}
    //     </Stack.Navigator>
    //   );
    // }

    return (
        <NavigationContainer>
            <Tab.Navigator screenOptions={() => ({
                headerShown: false,
                tabBarActiveTintColor: StyleColors.greenTab,
                tabBarInactiveTintColor: StyleColors.whiteTab,
                tabBarLabelStyle: {
                    fontSize: 14.5
                },
                tabBarStyle: {
                    height: 80,
                    paddingHorizontal: 0,
                    paddingTop: 0,
                    paddingBottom: 2,
                    backgroundColor: StyleColors.tabBackgroundColorBlue,
                    position: 'absolute',
                    borderTopWidth: 0,
                }
            })} >
                <Tab.Screen name="Dashboard" component={Dashboard} options={{
                    headerShown: false,
                    tabBarIcon: ({ focused }) => (<MaterialCommunityIcon name='view-dashboard-outline' size={35} color={focused ? StyleColors.greenTab : StyleColors.whiteTab} />),
                    tabBarLabel: "Dasboard"
                }} />
                <Tab.Screen name="Consumption" component={Consumption} options={{
                    headerShown: false,
                    tabBarIcon: ({ focused }) => (<FontAwesome6 name='chart-simple' size={32} color={focused ? StyleColors.greenTab : StyleColors.whiteTab} />),
                    tabBarLabel: "Ma Conso"
                }} />
                <Tab.Screen name="Alert" component={Alert} options={{
                    headerShown: false,
                    tabBarIcon: ({ focused }) => (<MaterialCommunityIcon name='alert-outline' size={38} color={focused ? StyleColors.greenTab : StyleColors.whiteTab} />),
                    tabBarLabel: "Mes alertes"
                }} />
                <Tab.Screen name="Notification" component={Notification} options={{
                    headerShown: false,
                    tabBarIcon: ({ focused }) => (<MaterialIcons name='notifications' size={37} color={focused ? StyleColors.greenTab : StyleColors.whiteTab} />),
                    tabBarLabel: "Notifications"
                }} />
                <Tab.Screen name="Account" component={Account} options={{
                    headerShown: false,
                    tabBarIcon: ({ focused }) => (<MaterialCommunityIcon name='account' size={42} color={focused ? StyleColors.greenTab : StyleColors.whiteTab} />),
                    tabBarLabel: "Compte"
                }} />
            </Tab.Navigator>
        </NavigationContainer>
    );
};

const styles = StyleSheet.create({});

export default Navigator;