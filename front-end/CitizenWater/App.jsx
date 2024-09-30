import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Dashboard from "./src/screens/Dashboard";
import { NavigationContainer } from "@react-navigation/native";
import { StyleSheet } from "react-native";
import Consumption from "./src/screens/Consumption";
import Alert from "./src/screens/Alert";
import Notification from "./src/screens/Notification";
import Account from "./src/screens/Account";
import MaterialCommunityIcon from 'react-native-vector-icons/MaterialCommunityIcons'
import FontAwesome6 from 'react-native-vector-icons/FontAwesome6'
import MaterialIcons from 'react-native-vector-icons/MaterialIcons'
import StyleColors from "./src/styles/StyleColors";


const App = () => {
    const Tab = createBottomTabNavigator();
    // const Stack = createNativeStackNavigator();

    // function MyStackNavigator() {
    //   return (
    //     <Stack.Navigator>
    //       <Stack.Screen name="HomeScreen" component={HomeScreen} options={{headerShown: false}}/>
    //       {/* <Stack.Screen name="DetailsPokemon" component={DetailsPokemonScreen} /> */}
    //     </Stack.Navigator>
    //   );
    // }

    const colors = {
        tabBackgroundColor: 'rgba(25,65,76,1)',
        greenTab: 'rgba(109,204,68,1)',
        whiteTab: 'rgba(250, 250, 250,1)'
    }

    return (
        //   <Provider store={store}>
        <NavigationContainer>
            <Tab.Navigator screenOptions={() => ({
                headerShown: false,
                tabBarActiveTintColor: StyleColors.greenTab,
                tabBarInactiveTintColor: StyleColors.whiteTab,
                tabBarLabelStyle: {
                    fontSize: 14.5
                } ,
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
                      tabBarIcon: ({color, focused}) => (<MaterialCommunityIcon name='view-dashboard-outline' size={35} color={focused?StyleColors.greenTab:StyleColors.whiteTab} />),
                    tabBarLabel: "Dasboard"
                }} />
                <Tab.Screen name="Consumption" component={Consumption} options={{
                    headerShown: false,
                        tabBarIcon: ({color, focused}) => (<FontAwesome6 name='chart-simple' size={32} color={focused?StyleColors.greenTab:StyleColors.whiteTab} />),
                    tabBarLabel: "Ma Conso"
                }} />
                <Tab.Screen name="Alert" component={Alert} options={{
                    headerShown: false,
                        tabBarIcon: ({color, focused}) => (<MaterialCommunityIcon name='alert-outline' size={38} color={focused?StyleColors.greenTab:StyleColors.whiteTab} />),
                    tabBarLabel: "Mes alertes"
                }} />
                <Tab.Screen name="Notification" component={Notification} options={{
                    headerShown: false,
                        tabBarIcon: ({color, focused}) => (<MaterialIcons name='notifications' size={37} color={focused?StyleColors.greenTab:StyleColors.whiteTab} />),
                    tabBarLabel: "Notifications"
                }} />
                <Tab.Screen name="Account" component={Account} options={{
                    headerShown: false,
                    tabBarIcon: ({color, focused}) => (<MaterialCommunityIcon name='account' size={42} color={focused?StyleColors.greenTab:StyleColors.whiteTab} />),
                    tabBarLabel: "Compte"
                }} />
            </Tab.Navigator>
        </NavigationContainer>
        //   </Provider>
    );
};

const styles = StyleSheet.create({});

export default App;