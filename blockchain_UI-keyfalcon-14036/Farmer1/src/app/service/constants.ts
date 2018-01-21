export const AppConstants = Object.freeze({
  // base_url: 'http://192.168.0.203:8088/parent/',
   base_url:  'http://192.168.0.203:8088/blockchain/',

 farmer: {
     base: 'farmer/',
     getAllFarmers: 'getAllFarmers',
     getAllFarmersByStatus: 'getAllFarmersByStatus',
     getAllLandDetailsByFarmer: 'getAllLandDetailsByFarmer',
     getProfilByFarmer : 'getProfilByFarmer',
     registerFarmer: 'registerFarmer'
   },
   nursery: {
     base: 'nursery/',
    registerNursery: 'registerNursery'
   }

 });
