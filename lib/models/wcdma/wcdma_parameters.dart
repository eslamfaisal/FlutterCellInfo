import '../common/network.dart';
import 'cdma_band.dart';
import 'cdma_signal.dart';

class Wcdma {
  BandWCDMA bandWCDMA;
  SignalWCDMA signalWCDMA;
  String connectionStatus;
  Network network;
  String type;

  Wcdma(
      {this.bandWCDMA,
        this.signalWCDMA,
        this.connectionStatus,
        this.network,
        this.type});

  Wcdma.fromJson(Map<String, dynamic> json) {
    bandWCDMA = json['bandWCDMA'] != null
        ? new BandWCDMA.fromJson(json['bandWCDMA'])
        : null;
    signalWCDMA = json['signalWCDMA'] != null
        ? new SignalWCDMA.fromJson(json['signalWCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
    json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandWCDMA != null) {
      data['bandWCDMA'] = this.bandWCDMA.toJson();
    }
    if (this.signalWCDMA != null) {
      data['signalWCDMA'] = this.signalWCDMA.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}