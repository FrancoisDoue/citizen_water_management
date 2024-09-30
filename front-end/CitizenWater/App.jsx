import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Dashboard from "./src/screens/Dashboard";
import { NavigationContainer } from "@react-navigation/native";
import { StyleSheet } from "react-native";
import Consumption from "./src/screens/Consumption";
import Alert from "./src/screens/Alert";
import Notification from "./src/screens/Notification";
import Account from "./src/screens/Account";

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

    return (
        //   <Provider store={store}>
        <NavigationContainer>
            <Tab.Navigator screenOptions={() => ({
                headerShown: false,
                tabBarStyle: {
                    height: 70,
                    paddingHorizontal: 5,
                    paddingTop: 0,
                    backgroundColor: 'rgba(62,61,61,1)',
                    position: 'absolute',
                    borderTopWidth: 0,
                },
            })} >
                <Tab.Screen name="Dashboard" component={Dashboard} options={{
                    headerShown: false,
                    //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                    tabBarLabel: "Dasboard"
                }} />
                <Tab.Screen name="Consumption" component={Consumption} options={{
                    headerShown: false,
                    //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                    tabBarLabel: "Ma Conso"
                }} />
                <Tab.Screen name="Alert" component={Alert} options={{
                    headerShown: false,
                    //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                    tabBarLabel: "Mes alertes"
                }} />
                <Tab.Screen name="Notification" component={Notification} options={{
                    headerShown: false,
                    //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                    tabBarLabel: "Notifications"
                }} />
                <Tab.Screen name="Account" component={Account} options={{
                    headerShown: false,
                    //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                    tabBarLabel: "Compte"
                }} />
            </Tab.Navigator>
        </NavigationContainer>
        //   </Provider>
    );
};

const styles = StyleSheet.create({});

export default App;