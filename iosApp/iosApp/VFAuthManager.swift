//
//  VFAuthManager.swift
//  iosApp
//
//  Created by Martin De Simone on 21/11/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import ViafouraSDK

@objc
public class VFAuthManager: NSObject {
    let auth = ViafouraSDK.auth()
    
    @objc
    public func getLoggedInStatus(completion: @escaping (Bool) -> Void){
        auth.getUserLoginStatus(completion: { result in
            switch result {
            case .success(let loginStatus):
                if case .loggedIn(let userUUID) = loginStatus {
                    completion(true)
                } else if case .notLoggedIn = loginStatus {
                    completion(false)
                }
            case .failure(let error):
                completion(false)
            }
        })
    }
    
    
    @objc
    public func cookieLogin(token: String, completion: @escaping (Bool) -> Void){
        auth.cookieLogin(token: token, completion: { result in
            switch result {
            case .success(let data):
                completion(true)
            case .failure(let error):
                completion(false)
            }
        })
    }
    
    @objc
    public func login(email: String, password: String, completion: @escaping (Bool) -> Void){
        auth.login(email: email, password: password, completion: { result in
            switch result {
            case .success(let data):
                completion(true)
            case .failure(let error):
                completion(false)
            }
        })
    }
    
    @objc
    public func logout(){
        auth.logout()
    }
}
