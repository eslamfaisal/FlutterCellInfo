import 'package:cell_info/models/common/common_wtdscdma_parameters.dart';

class TdsCDMAParameters extends CommonWCDMAParameters {
  int cpid;

  TdsCDMAParameters({
    this.cpid,
  });

  TdsCDMAParameters.fromJson(Map<String, dynamic> map) {
    this.cpid = map['cpid'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['cpid'] = this.cpid;
      return data;
    }
  }
}