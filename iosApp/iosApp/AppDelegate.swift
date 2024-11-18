//
//  AppDelegate.swift
//  iosApp
//
//  Created by Martin De Simone on 18/11/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit
import ViafouraSDK

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        ViafouraSDK.initialize(siteUUID: "00000000-0000-4000-8000-c8cddfd7b365", siteDomain: "viafoura-mobile-demo.vercel.app")
        return true
    }
}
