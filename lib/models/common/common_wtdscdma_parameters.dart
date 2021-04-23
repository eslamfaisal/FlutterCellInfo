import 'package:cell_info/models/common/cell_info.dart';

class CommonWCDMAParameters extends BasicCellInfo {
  int ci;
  int rnc;
  int cid;
  int lac;
  int rssi;
  int bitErrorRate;
  int rscp;

  CommonWCDMAParameters({
    this.ci,
    this.rnc,
    this.cid,
    this.lac,
    this.rssi,
    this.bitErrorRate,
    this.rscp,
  });

  CommonWCDMAParameters.fromJson(Map<String, dynamic> map) {
    this.ci = map['ci'];
    this.rnc = map['rnc'];
    this.cid = map['cid'];
    this.lac = map['lac'];
    this.rssi = map['rssi'];
    this.bitErrorRate = map['bitErrorRate'];
    this.rscp = map['rscp'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['ci'] = this.ci;
      data['rnc'] = this.rnc;
      data['cid'] = this.cid;
      data['lac'] = this.lac;
      data['rssi'] = this.rssi;
      data['bitErrorRate'] = this.bitErrorRate;
      data['rscp'] = this.rscp;
      return data;
    }
  }
}