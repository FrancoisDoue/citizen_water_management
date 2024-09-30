import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Dashboard from "./src/screens/Dashboard";
import { NavigationContainer } from "@react-navigation/native";
import { StyleSheet } from "react-native";

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
              <Tab.Navigator>
                  <Tab.Screen name="Home" component={Dashboard} options={{headerShown: false,
                //   tabBarIcon: () => (<Icon name='home-circle' size={25} color={"black"}/>),
                  tabBarLabel: "Dasboard"
                  }}/>
                  {/* <Tab.Screen name="Search" component={SearchScreen} options={{headerShown: false,
                  tabBarIcon: () => (<Icon2 name='search' size={25} color={"black"}/>),
                  tabBarLabel: "Rechercher"
                  }}/>
                  <Tab.Screen name="CollectionScreen" component={PersonnalCollectionScreen} options={{
                    title: "Collection",
                    tabBarIcon: () => (<Icon name='pokeball' size={25} color={"black"}/>),
                    tabBarLabel: "Collection"
                    }}/> */}
              </Tab.Navigator>
          </NavigationContainer>
    //   </Provider>
    );
  };
  
  const styles = StyleSheet.create({});
  
  export default App;