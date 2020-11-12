//
//  EventoRepository.swift
//  BMOGeradorDeSwift
//
//  Created by Breno Medeiros e João Paulo at 13/11/20
//  Copyright © 2020 BJ. All rights reserved.
//

import Foundation

class EventoRepository{
    
    private static let basePath = Constants.API_URL + "/evento"
    
    
    private static let session = URLSession(configuration: Constants.configuration)   //URLSession.shared
    
    class func add(onComplete: @escaping ([BJEvento]) -> Void, onError: @escaping (Constants.ComunicationError) -> Void)  {
        
    }
    
    class func edit(onComplete: @escaping ([BJEvento]) -> Void, onError: @escaping (Constants.ComunicationError) -> Void)  {
        
    }
    
    class func remove(onComplete: @escaping ([BJEvento]) -> Void, onError: @escaping (Constants.ComunicationError) -> Void)  {
        
    }
    
    class func getOne(id: Int , onComplete: @escaping ([BJEvento]) -> Void, onError: @escaping (Constants.ComunicationError) -> Void)  {
        
        guard let url = URL(string: basePath + "/\(id)") else {return}
        
        let dataTask = session.dataTask(with: url) { (data: Data?, response:URLResponse?, error:Error?) in
            
            if error == nil {
                guard let response = response as? HTTPURLResponse else {
                    
                    onError(.noResponse)
                    
                    return
                    
                }
                
                if response.statusCode == 200 {
                    
                    guard let data = data else {return}
                    
                    do {
                        
                        let entity = try JSONDecoder().decode(EventoResponse.self, from: data)
                        
                        onComplete(entity.data)
                        
                    } catch {
                        
                        onError(.invalidJSON)
                        
                    }
                } else {
                    
                    onError(.responseStatusCode(code: response.statusCode))
                    
                }
            } else {
                
                onError(.taskError(error: error!))
                
            }
        }
        
        dataTask.resume()
    }
    
    class func getAll(onComplete: @escaping ([BJEvento]) -> Void, onError: @escaping (Constants.ComunicationError) -> Void)  {
        guard let url = URL(string: basePath) else {return}
        
        let dataTask = session.dataTask(with: url) { (data: Data?, response:URLResponse?, error:Error?) in
            
            if error == nil {
                guard let response = response as? HTTPURLResponse else {
                    
                    onError(.noResponse)
                    
                    return
                    
                }
                
                if response.statusCode == 200 {
                    
                    guard let data = data else {return}
                    
                    var str = String(data: data, encoding: .utf8)
                    str = str?.replacingOccurrences(of: "null", with: "\"\"")
                    let strData: Data? = str!.data(using: .utf8)
                    
                    do {
                        
                        let entity = try JSONDecoder().decode(EventoResponse.self, from: strData!)
                        
                        onComplete(entity.data)
                        
                    } catch {
                        
                        onError(.invalidJSON)
                        
                    }
                } else {
                    
                    onError(.responseStatusCode(code: response.statusCode))
                    
                }
            } else {
                
                onError(.taskError(error: error!))
                
            }
        }
        
        dataTask.resume()
    }
    
}

